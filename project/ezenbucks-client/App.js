import * as React from "react";
import { Platform, StatusBar, View } from "react-native";
import { ActionSheetProvider } from "@expo/react-native-action-sheet";
import useCachedResources from "./hooks/useCachedResources";
import Navigation from "./navigation/Navigation";

function App(props) {
  const isLoadingComplete = useCachedResources();

  if (!isLoadingComplete) {
    return null;
  } else {
    return (
      <ActionSheetProvider>
        <View style={{ flex: 1 }}>
          {Platform.OS === "ios" && <StatusBar barStyle="dark-content" />}
          {Platform.OS === "android" && <StatusBar barStyle="light-content" />}
          <Navigation />
        </View>
      </ActionSheetProvider>
    );
  }
}

export default App;
