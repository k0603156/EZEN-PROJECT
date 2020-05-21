import * as React from "react";
import styled from "styled-components";
import { View, Text } from "react-native";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

const GreetContainer = styled.View`
  background-color: ${Colors.darkGray};
  padding: 5px 0;
  text-align: center;
`;
const GreetText = styled.Text`
color:${Colors.fontColor}
text-align:center;
`;
export default function Greeting({ message }) {
  return (
    <GreetContainer>
      <GreetText>{message}</GreetText>
    </GreetContainer>
  );
}
