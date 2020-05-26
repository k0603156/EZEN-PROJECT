import * as React from "react";
import { Platform, StatusBar, View } from "react-native";
import useCachedResources from "./hooks/useCachedResources";

import Navigation from "./navigation/Navigation";

function App(props) {
  const isLoadingComplete = useCachedResources();

  if (!isLoadingComplete) {
    return null;
  } else {
    return (
      <View style={{ flex: 1 }}>
        {Platform.OS === "ios" && <StatusBar barStyle="dark-content" />}
        {Platform.OS === "android" && <StatusBar barStyle="light-content" />}
        <Navigation />
      </View>
    );
  }
}

export default App;
