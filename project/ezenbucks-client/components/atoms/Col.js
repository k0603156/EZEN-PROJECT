import * as React from "react";
import styled from "styled-components";

const View = styled.View`
  ${() => `
    display: flex;
    flex-direction: column;
    margin: 8px 8px 0 8px;
  `};
  ${({ style }) => style};
`;

export default function Col({ className, children, style, ...props }) {
  return (
    <View className={className} style={style} {...props}>
      {children}
    </View>
  );
}
