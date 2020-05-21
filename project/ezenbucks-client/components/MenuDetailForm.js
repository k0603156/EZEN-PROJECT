import * as React from "react";
import styled from "styled-components";
import { Text, Picker } from "react-native";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";
import Button from "./Button";

const Sheet = styled.View`
  display: flex;
  margin: 24px;
`;
const SheetTitle = styled.Text`
  font-size: 24px;
`;
const SheetAmount = styled.Text`
  font-size: 18px;
  text-align: right;
`;
const SheetOptionView = styled.View`
  display: flex;
  flex: 1;
`;
const SheetBtnView = styled.View`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

export default function MenuDetailForm({ title }) {
  const [state, setState] = React.useState({
    size: "Tall",
    temp: "Hot",
  });
  const onValueChange = (itemValue, itemIndex) => {
    setState({ ...state, size: itemValue });
  };
  return (
    <Sheet>
      <SheetTitle>{title}</SheetTitle>
      <SheetAmount>5,600원</SheetAmount>
      <SheetOptionView>
        <Text>사이즈</Text>
        <Picker
          selectedValue={state.size}
          style={{ height: 50, width: 150 }}
          onValueChange={onValueChange}
        >
          <Picker.Item label="Tall" value="Tall" />
          <Picker.Item label="Regular" value="Regular" />
        </Picker>
        <Text>Hot/Cold</Text>
        <Button text="Hot" />
        <Button text="Cold" />
      </SheetOptionView>
      <SheetBtnView>
        <Button text="주문" />
        <Button text="취소" />
      </SheetBtnView>
    </Sheet>
  );
}
