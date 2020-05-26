import * as React from "react";
import styled from "styled-components";
import { useNavigation } from "@react-navigation/native";
import Colors from "../../constants/Colors";
import Button from "../atoms/Button";

export default function CartButton() {
  const navigation = useNavigation();
  const onPress = () => {
    navigation.navigate("Cart");
  };
  return (
    <Button
      title="cart"
      onPress={onPress}
      style={{ marginRight: 16 }}
      textStyle={{ color: Colors.white }}
    />
  );
}
