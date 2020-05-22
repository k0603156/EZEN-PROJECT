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
  const [state, setState] = React.useState({
    selectedItem: 0,
    items: [
      { name: "나이트로 바닐라 크림" },
      { name: "초콜릿 블랙 콜드 브루" },
      { name: "코코넛 화이트 콜드 브루" },
    ],
  });

  const onSnapItem = (selectedItem) => {
    setState({ ...state, selectedItem });
  };
  const onSheetOpen = () => {
    modalizeRef.current?.open();
  };

  const onSheetClose = () => {
    modalizeRef.current?.close();
  };

  const onBtnOrder = () => {
    navigation.navigate("Shop");
  };

  return (
    <Container>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <Container>
        <LinearGradient
          colors={[Colors.darkGray, "transparent"]}
          style={gradientStyle}
        />
        <View>
          <ProductCarousel items={state.items} onSnapToItem={onSnapItem} />
        </View>
        <Button text="Order" onPress={onSheetOpen} />
        <BottomSheet
          useRef={modalizeRef}
          adjustToContentHeight
          sheet={
            <MenuDetailForm
              title={state.items[state.selectedItem].name}
              onBtnOrder={onBtnOrder}
              onBtnCancel={onSheetClose}
            />
          }
        />
      </Container>
    </Container>
  );
}

export default Menu;
