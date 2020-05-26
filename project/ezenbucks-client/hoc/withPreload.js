import * as React from "react";
import { Asset } from "expo-asset";
import AppLoading from "../components/molcules/AppLoading";

export default function usePreload({ apis = [], images = [] }) {
  return (component) => (props) => {
    const [isReady, setIsReady] = React.useState(false);
    const [fetchDatas, setFetchDatas] = React.useState();
    const Component = component;

    const preload = async () => {
      try {
        const responsDatas = await Promise.all([...apis.map((api) => api())]);
        await Promise.all([
          ...images.map((image) => Asset.fromModule(image).downloadAsync()),
        ]);
        setFetchDatas(
          responsDatas.reduce(
            (acc, response) => Object.assign(acc, response?.data),
            {}
          )
        );
      } catch (error) {
        console.warn(error);
      }
    };

    const onFinish = () => {
      setIsReady(true);
    };
    return isReady ? (
      <Component {...props} preloadData={fetchDatas} />
    ) : (
      <AppLoading
        startAsync={preload}
        onFinish={onFinish}
        onError={console.warn}
        autoHideSplash={false}
      />
    );
  };
}
