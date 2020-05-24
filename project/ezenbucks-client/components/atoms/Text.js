import * as React from "react";
import styled from "styled-components";
import Colors from "../../constants/Colors";
import Layout, { Size } from "../../constants/Layout";

const Text = styled.Text`
  ${({ size, color, textAlign }) => `
  font-size:${Size(size)};
  color: ${color};
  text-align: ${textAlign};
  `};
`;

export default ({
  className,
  color = Colors.fontColor,
  size = "md",
  textAlign = "left",
  title,
  style,
  ...props
}) => {
  return (
    <Text
      className={className}
      color={color}
      size={size}
      textAlign={textAlign}
      style={style}
      {...props}
    >
      {title}
    </Text>
  );
};
