import * as React from "react";
import styled from "styled-components";

const View = styled.View`
  ${({}) => `
    display: flex;
    flex-direction: row;
    padding: 8px 0;
  `};
`;

export default function Row({ className, children, style, ...props }) {
  return (
    <View className={className} style={style} {...props}>
      {children}
    </View>
  );
}
