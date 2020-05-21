import * as React from "react";
import styled from "styled-components";
import { Platform, StatusBar, View } from "react-native";
import { Provider, observer } from "mobx-react";
import useCachedResources from "./hooks/useCachedResources";
import Navigation from "./navigation/Navigation";
import Colors from "./constants/Colors";
import stores from "./store";

export default function App(props) {
  const isLoadingComplete = useCachedResources();

  if (!isLoadingComplete) {
    return null;
  } else {
    return (
      <Provider rootStore={stores}>
        <View style={{ flex: 1 }}>
          {Platform.OS === "ios" && <StatusBar barStyle="dark-content" />}
          {Platform.OS === "android" && <StatusBar barStyle="light-content" />}
          <Navigation />
        </View>
      </Provider>
    );
  }
}
