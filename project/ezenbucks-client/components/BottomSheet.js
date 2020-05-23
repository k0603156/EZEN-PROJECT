import * as React from "react";
import styled from "styled-components";
import { Text, Picker, CheckBox } from "react-native";
import { Modalize } from "react-native-modalize";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

export default function BottomSheet({
  useRef,
  modalHeight,
  sheet,
  onBackButtonPress,
  onOpened,
  onClosed,
  HeaderComponent,
  FloatingComponent,
  FooterComponent,
  adjustToContentHeight,
}) {
  return (
    <Modalize
      ref={useRef}
      modalHeight={modalHeight}
      onBackButtonPress={onBackButtonPress}
      onOpened={onOpened}
      onClosed={onClosed}
      HeaderComponent={HeaderComponent}
      FloatingComponent={FloatingComponent}
      FooterComponent={FooterComponent}
      adjustToContentHeight={adjustToContentHeight}
    >
      {sheet}
    </Modalize>
  );
}
