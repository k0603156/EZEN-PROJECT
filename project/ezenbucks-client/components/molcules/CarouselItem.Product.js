import * as React from "react";
import styled from "styled-components";
import { View } from "react-native";
import Layout, { normalize } from "../../constants/Layout";

const ProductImage = styled.Image`
  width: ${Layout.window.width}px;
  height: ${Layout.window.height - 200}px;
`;
const ProductName = styled.Text`
  text-align: center;
  font-size: ${normalize(18)}px;
  font-family: bigshot-one;
`;
export default function ProductItem({ item }) {
  return (
    <View>
      <ProductImage resizeMode={"contain"} source={{ uri: item.image }} />
      <ProductName>{item.name}</ProductName>
    </View>
  );
}
