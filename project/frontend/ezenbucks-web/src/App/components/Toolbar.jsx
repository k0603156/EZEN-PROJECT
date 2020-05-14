import React from "react";
import styled from "styled-components";

function Toolbar({ className }) {
  return (
    <header className={className}>
      <div className="title">EZEN-BUCKS</div>
      <div className="greeting">안녕하세요. 스타벅스입니다.</div>
    </header>
  );
}
export default styled(Toolbar)`
  ${({
    theme: {
      toolbar: { height },
      color: { deepBlack, white },
    },
  }) => `
  height: ${height};
  display:flex;
  flex-direction:column;
  justify-content: space-around;
  background-color: ${deepBlack};
  color: ${white};
  text-align: center;
  .title{
    font-size:1.2rem;
  }
  .greeting{
    flex-basis:20px;
  }
  `};
`;
