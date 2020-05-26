import "react-native-gesture-handler";
import "react-native-reanimated";
import * as React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import Colors from "../constants/Colors";
import { normalize } from "../constants/Layout";
import CartButton from "../components/molcules/CartButton";
import Cart from "../screens/Cart";
import Home from "../screens/Home";
import Menu from "../screens/Menu";
import Order from "../screens/Order";
import Shop from "../screens/Shop";

const MainNavigation = createStackNavigator();

const ScreenOptions = {
  headerTitleAlign: "center",
  headerTintColor: Colors.fontColor,
  headerTitleStyle: {
    color: Colors.fontColor,
    fontSize: normalize(32),
    fontFamily: "bigshot-one",
  },
  headerStyle: { backgroundColor: Colors.headerColor },
};

export default function Navigation() {
  return (
    <NavigationContainer>
      <MainNavigation.Navigator
        initialRouteName="Home"
        screenOptions={ScreenOptions}
      >
        <MainNavigation.Screen
          name="Home"
          component={Home}
          options={({ navigation, route }) => ({
            title: "EZEN-BUCKS",
          })}
        />
        <MainNavigation.Screen
          name="Menu"
          component={Menu}
          options={({ navigation, route }) => ({
            title: "Menu",
            headerRight: () => <CartButton />,
          })}
        />
        <MainNavigation.Screen
          name="Shop"
          component={Shop}
          options={({ navigation, route }) => ({
            title: "Search",
          })}
        />
        <MainNavigation.Screen
          name="Order"
          component={Order}
          options={({ navigation, route }) => ({
            title: "Order",
          })}
        />
        <MainNavigation.Screen
          name="Cart"
          component={Cart}
          options={({ navigation, route }) => ({
            title: "Cart",
          })}
        />
      </MainNavigation.Navigator>
    </NavigationContainer>
  );
}
