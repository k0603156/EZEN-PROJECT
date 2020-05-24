import * as React from "react";
import styled from "styled-components";

const FlatList = styled.FlatList`
  ${({}) => `
  `};
  ${({ style }) => style};
`;

export default function ({ className, children, style, ...props }) {
  return (
    <FlatList className={className} style={style} {...props}>
      {children}
    </FlatList>
  );
}
