import * as React from "react";
import styled from "styled-components";
import { LinearGradient } from "expo-linear-gradient";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

import Button from "../components/atoms/Button";
import BottomSheet from "../components/molcules/BottomSheet";
import {
  BottomSheetFormHeader,
  BottomSheetFormFooter,
  BottomSheetToggle,
} from "../components/molcules/BottomSheetForm";
import Carousel from "../components/molcules/Carousel";
import CarouselItem from "../components/molcules/CarouselItem.Product";
import Greeting from "../components/molcules/Greeting";
import withPreload from "../hoc/withPreload";
import useInput from "../hooks/useInput";
import { fetchListItem } from "../services/api";

const Container = styled.View`
  display: flex;
  flex: 1;
  flex-direction: column;
`;
const OrderButton = styled(Button)`
  margin: 16px;
  background-color: ${Colors.darkGreen};
  border-radius: 8px;
`;
const gradientStyle = {
  position: "absolute",
  left: 0,
  right: 0,
  top: 0,
  height: Layout.window.height - 150,
};
function Menu({ navigation, route, preloadData }) {
  const modalizeRef = React.useRef(null);
  const [response, setResponse] = React.useState([]);
  const itemSelected = useInput(0);
  const itemTemp = useInput("ICE");

  const selectedItem = response[itemSelected.value];
  const BottomSheetBodyComponent = selectedItem?.itemSpecies === "coffee" && (
    <Container>
      <BottomSheetToggle
        title="HOT/ICE"
        options={["HOT", "ICE"]}
        selectedOption={itemTemp.value}
        onValueChange={(option) => itemTemp.onChange(option)}
      />
    </Container>
  );

  console.log(preloadData);
  const fetchItems = async () => {
    try {
      const { status, data } = await fetchListItem();
      if (status === 200) {
        setResponse(toCamelCaseObjectKey(data));
      }
    } catch (error) {
      console.log(error.message);
    }
  };

  React.useEffect(() => {
    fetchItems();
  }, []);

  const onSnapItem = (selectedItem) => itemSelected.onChange(selectedItem);

  const onSheetOpen = () => modalizeRef.current?.open();

  const onSheetClose = () => modalizeRef.current?.close();

  const onPositive = () => {
    modalizeRef.current?.close();
    navigation.navigate("Shop", { items: [response[itemSelected.value]] });
  };
  const onBackButtonPress = () => modalizeRef.current?.close();

  return (
    <Container>
      <Greeting message="안녕하세요. 스타벅스입니다." />
      <Container>
        <LinearGradient
          colors={[Colors.darkGray, "transparent"]}
          style={gradientStyle}
        />
        <Container>
          <Carousel
            data={response}
            renderItem={CarouselItem}
            onSnapToItem={onSnapItem}
            style={{ flex: 1 }}
          />
          <OrderButton
            title="Order"
            onPress={onSheetOpen}
            textStyle={{ color: Colors.fontColor }}
          />
        </Container>

        <BottomSheet
          useRef={modalizeRef}
          adjustToContentHeight
          onBackButtonPress={onBackButtonPress}
          withReactModal
          HeaderComponent={
            <BottomSheetFormHeader
              title={selectedItem?.itemName}
              subTitle={selectedItem?.itemPrice + "원"}
            />
          }
          BodyComponent={BottomSheetBodyComponent}
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

export default withPreload({ apis: [fetchListItem] })(Menu);

//api에서 오는 데이터 네이밍 케이스가 맞지 않아 변경
const toCamelCaseObjectKey = (objectArr) => {
  return objectArr.map((item) =>
    Object.entries(item).reduce((acc, [key, value]) => {
      return Object.assign(acc, { [toCamelCase(key)]: value });
    }, {})
  );
};
const toCamelCase = (str) =>
  String(str)
    .toLowerCase()
    .replace(/[^a-zA-Z0-9]+(.)/g, (m, chr) => chr.toUpperCase());
