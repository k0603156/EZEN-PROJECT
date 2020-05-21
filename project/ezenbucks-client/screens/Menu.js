import * as React from "react";
import styled from "styled-components";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
import Greeting from "../components/Greeting";
import { View } from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import ProductCarousel from "../components/ProductCarousel";
import BottomSheet from "../components/BottomSheet";
import MenuDetailForm from "../components/MenuDetailForm";
import Button from "../components/Button";

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
  const modalizeRef = React.useRef(null);
  const onOpen = () => {
    modalizeRef.current?.open();
  };
  const [items, setItems] = React.useState([
    { name: "나이트로바닐라크림" },
    { name: "나이트로바닐라크림" },
    { name: "나이트로바닐라크림" },
  ]);

  return (
    <Container>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <Container>
        <LinearGradient
          colors={[Colors.darkGray, "transparent"]}
          style={gradientStyle}
        />
        <View>
          <ProductCarousel items={items} />
        </View>
        <Button text="Order" onPress={onOpen} />
        <BottomSheet
          useRef={modalizeRef}
          sheet={<MenuDetailForm title="나이트로 바닐라 크림" />}
        />
      </Container>
    </Container>
  );
}

export default Menu;
