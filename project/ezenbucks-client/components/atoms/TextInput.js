import * as React from "react";
import { TextInput } from "react-native";
import styled from "styled-components";
import Colors from "../../constants/Colors";
import Layout from "../../constants/Layout";

export default styled(
  ({
    placeholder,
    placeholderTextColor = "white",
    value,
    onChangeText,
    style,
    ...props
  }) => {
    return (
      <TextInput
        placeholder={placeholder}
        placeholderTextColor={placeholderTextColor}
        value={value}
        onChangeText={onChangeText}
        style={style}
        {...props}
      />
    );
  },
)`
  padding: 8px;
  color: white;
`;
