import React from "react";
import Toolbar from "./Toolbar";

export default function Layout({ children }) {
  return (
    <div className={"App"}>
      <Toolbar />
      {children}
    </div>
  );
}
