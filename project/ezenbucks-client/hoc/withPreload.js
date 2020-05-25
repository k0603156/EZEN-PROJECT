import * as React from "react";
import { Asset } from "expo-asset";
import AppLoading from "../components/molcules/AppLoading";

export default function usePreload(...images) {
  return (component) => (props) => {
    const [isReady, setIsReady] = React.useState(false);
    const Component = component;
    const assets = images.map((image) => Asset.fromModule(image).localUri);

    const preload = async () => {
      await Promise.all([
        ...images.map((image) => Asset.fromModule(image).downloadAsync()),
        new Promise((resolve, reject) => {
          setTimeout(resolve, 30);
        }),
      ]).catch((e) => {
        console.warn(e);
      });
    };

    const onFinish = () => {
      setIsReady(true);
    };
    return isReady ? (
      <Component {...props} assets={assets} />
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
