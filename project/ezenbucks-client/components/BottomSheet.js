import * as React from "react";
import styled from "styled-components";
import { Text, Picker, CheckBox } from "react-native";
import { Modalize } from "react-native-modalize";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

export default function BottomSheet({ useRef, sheet }) {
  return (
    <Modalize ref={useRef} modalHeight={Layout.window.height / 2.5}>
      {sheet}
    </Modalize>
  );
}
