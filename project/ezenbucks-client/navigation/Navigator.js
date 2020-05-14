import * as React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import HomeScreen from "../screens/HomeScreen";
import ListScreen from "../screens/ListScreen";

export default function Navigator() {
  const Stack = createStackNavigator();
  return (
    <Stack.Navigator initialRouteName={"home"}>
      <Stack.Screen name="home" component={HomeScreen} />
      <Stack.Screen name="list" component={ListScreen} />
    </Stack.Navigator>
  );
}
