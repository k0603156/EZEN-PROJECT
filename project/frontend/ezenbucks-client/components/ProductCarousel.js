import * as React from "react";
import styled from "styled-components";
import { View } from "react-native";
import Carousel from "react-native-snap-carousel";
import Layout, { normalize } from "../constants/Layout";
import Colors from "../constants/Colors";

const ProductImage = styled.Image`
  width: ${Layout.window.width}px;
  height: ${Layout.window.height - 200}px;
`;
const ProductName = styled.Text`
  text-align: center;
  font-size: ${normalize(18)}px;
  font-family: bigshot-one;
`;
function ProductItem({ item: { name } }) {
  return (
    <View>
      <ProductImage
        resizeMode={"contain"}
        source={require("../assets/images/coffee.png")}
      />
      <ProductName>{name}</ProductName>
    </View>
  );
}

export default function ProductCarousel({ items }) {
  return (
    <View>
      <Carousel
        data={items}
        renderItem={ProductItem}
        sliderWidth={Layout.window.width}
        itemWidth={Layout.window.width}
      />
    </View>
  );
}
