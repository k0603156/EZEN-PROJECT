import "react-native-gesture-handler";
import "react-native-reanimated";
import * as React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator, HeaderTitle } from "@react-navigation/stack";
import Color from "../constants/Colors";
import { normalize } from "../constants/Layout";
import Home from "../screens/Home";
import Menu from "../screens/Menu";
import Order from "../screens/Order";
import Shop from "../screens/Shop";

const MainNavigation = createStackNavigator();

const NavigationOptions = {
  headerTitleAlign: "center",
  headerTintColor: Color.fontColor,
  headerTitleStyle: {
    color: Color.fontColor,
    fontSize: normalize(32),
    fontFamily: "bigshot-one",
  },
  headerStyle: { backgroundColor: Color.headerColor },
};

export default function Navigation() {
  return (
    <NavigationContainer>
      <MainNavigation.Navigator
        initialRouteName="Home"
        screenOptions={NavigationOptions}
      >
        <MainNavigation.Screen
          name="Home"
          component={Home}
          options={{ title: "EZEN-BUCKS" }}
        />

        <MainNavigation.Screen
          name="Menu"
          component={Menu}
          options={{
            title: "Menu",
          }}
        />
        <MainNavigation.Screen
          name="Shop"
          component={Shop}
          options={{ title: "Search" }}
        />
        <MainNavigation.Screen
          name="Order"
          component={Order}
          options={{ title: "Order" }}
        />
      </MainNavigation.Navigator>
    </NavigationContainer>
  );
}
