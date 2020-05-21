import * as React from "react";
import styled from "styled-components";
import Colors from "../constants/Colors";
import Layout from "../constants/Layout";

const Container = styled.TouchableOpacity`
  align-items: center;
  flex: 1;
  justify-content: center;
  margin-top: 10px;
  padding: 5px;
`;

const ButtonText = styled.Text``;

export default function OrderButton({
  className,
  text,
  onPress,
  icon,
  style,
  textStyle,
}) {
  return (
    <Container className={className} onPress={onPress} style={style}>
      {icon}
      <ButtonText style={textStyle}>{text}</ButtonText>
    </Container>
  );
}
