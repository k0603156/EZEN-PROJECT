import * as React from "react";
import { AppLoading } from "expo";
import { Asset } from "expo-asset";

export default function usePreload(...images) {
  return (component) => (props) => {
    const [isReady, setIsReady] = React.useState(false);
    const Component = component;
    const assets = images.map((image) => Asset.fromModule(image).localUri);

    const preload = async () => {
      await Promise.all(
        images.map((image) => Asset.fromModule(image).downloadAsync()),
      ).catch((e) => {
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
