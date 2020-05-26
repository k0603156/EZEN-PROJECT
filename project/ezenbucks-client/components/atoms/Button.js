import * as React from "react";
import styled from "styled-components";
import Colors from "../../constants/Colors";
import Layout from "../../constants/Layout";

const Container = styled.TouchableOpacity`
  align-items: center;
  margin-top: 10px;
  padding: 8px 0;
  ${({ style }) => style}
`;

const ButtonText = styled.Text`
  ${({ style }) => style}
`;

export default function Button({
  className,
  title,
  onPress,
  icon,
  style,
  textStyle,
}) {
  return (
    <Container className={className} onPress={onPress} style={style}>
      {icon}
      <ButtonText style={textStyle}>{title}</ButtonText>
    </Container>
  );
}
