import * as React from "react";
import styled from "styled-components";
import { Ionicons, MaterialCommunityIcons } from "@expo/vector-icons";
import { Text } from "react-native";
import { useNavigation } from "@react-navigation/native";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
const BtnContainer = styled.TouchableOpacity`
  align-items: center;
  flex: 1;
  justify-content: center;
`;
const getIcon = (lib) => {
  switch (lib) {
    case "ion-icons":
      return Ionicons;
    case "material-community-icons":
      return MaterialCommunityIcons;
  }
};
export default function OrderButton({
  lib,
  name,
  size = 24,
  color = "white",
  message,
  to,
}) {
  const Icon = getIcon(lib);
  const navigation = useNavigation();
  return (
    <BtnContainer onPress={() => navigation.navigate(to)}>
      <Icon name={name} size={size} color={color} />
      <Text style={{ color }}>{message}</Text>
    </BtnContainer>
  );
}
