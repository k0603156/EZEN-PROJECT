import * as React from "react";
import styled from "styled-components";

const Image = styled.Image`
  ${({}) => `

  `};
  ${({ style }) => style};
`;

export default function ({
  className,
  style,
  defaultSource = { uri: "https://reactnative.dev/img/tiny_logo.png" },
  ...props
}) {
  return (
    <Image
      className={className}
      style={style}
      defaultSource={defaultSource}
      {...props}
    />
  );
}
