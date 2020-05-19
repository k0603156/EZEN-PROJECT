import * as React from "react";
import styled from "styled-components";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
import Greeting from "../components/Greeting";
import useStores from "../hooks/useStores";
import { View } from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import ProductCarousel from "../components/ProductCarousel";

const Container = styled.View`
  display: flex;
  flex: 1;
  flex-direction: column;
`;
const gradientStyle = {
  position: "absolute",
  left: 0,
  right: 0,
  top: 0,
  height: Layout.window.height - 150,
};
function Menu({ navigation, route }) {
  const store = useStores();
  const [items, setItems] = React.useState([
    { name: "나이트로바닐라크림" },
    { name: "나이트로바닐라크림" },
    { name: "나이트로바닐라크림" },
  ]);

  return (
    <Container>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <View>
        <LinearGradient
          colors={[Colors.darkGray, "transparent"]}
          style={gradientStyle}
        />
        <ProductCarousel items={items} />
      </View>
    </Container>
  );
}

export default Menu;
