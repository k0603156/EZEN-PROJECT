import * as React from "react";
import styled from "styled-components";
import { View } from "react-native";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

const Container = styled.View`
  background-color: ${Colors.bgColor};
  display: flex;
  flex: 1;
  flex-direction: column;
`;
export default function Order() {
  return <Container></Container>;
}
