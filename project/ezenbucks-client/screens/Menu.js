import * as React from "react";
import styled from "styled-components";
import { View } from "react-native";

import { LinearGradient } from "expo-linear-gradient";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

import Button from "../components/atoms/Button";
import BottomSheet from "../components/molcules/BottomSheet";
import BottomSheetFormBody, {
  BottomSheetFormHeader,
  BottomSheetFormFooter,
} from "../components/molcules/BottomSheetForm";
import Carousel from "../components/molcules/Carousel";
import CarouselItem from "../components/molcules/CarouselItem.Product";
import Greeting from "../components/molcules/Greeting";
import withPreload from "../hoc/withPreload";

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

function Menu({ navigation, route, assets }) {
  const modalizeRef = React.useRef(null);
  const [state, setState] = React.useState({
    isReady: false,
    selectedItem: 0,
    items: [
      {
        name: "피치 젤리 아이스티",
        amount: "5,800원",
        image: assets[0],
      },
      {
        name: "블랙 와플칩 크림 프라푸치노",
        amount: "7,800원",
        image: assets[1],
      },
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

  const onPositive = () => {
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
          <Carousel
            data={state.items}
            renderItem={CarouselItem}
            onSnapToItem={onSnapItem}
          />
        </View>
        <Button title="Order" onPress={onSheetOpen} />
        <BottomSheet
          useRef={modalizeRef}
          adjustToContentHeight
          HeaderComponent={
            <BottomSheetFormHeader
              title={state.items[state.selectedItem].name}
              subTitle={state.items[state.selectedItem].amount}
            />
          }
          BodyComponent={<BottomSheetFormBody />}
          FooterComponent={
            <BottomSheetFormFooter
              titlePositive="주문"
              titleNegative="취소"
              onPositive={onPositive}
              onNegative={onSheetClose}
            />
          }
        />
      </Container>
    </Container>
  );
}

export default withPreload(
  require("../assets/images/피치_젤리_아이스_티.png"),
  require("../assets/images/블랙_와플칩_크림_프라푸치노.png"),
)(Menu);
