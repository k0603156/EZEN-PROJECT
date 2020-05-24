import * as React from "react";
import styled from "styled-components";

const View = styled.View`
  ${() => `
    padding: 8px;
    text-align: center;
  `};
  ${({ style }) => style};
`;

export default function Container({ className, children, style, ...props }) {
  return (
    <View className={className} style={style} {...props}>
      {children}
    </View>
  );
}
