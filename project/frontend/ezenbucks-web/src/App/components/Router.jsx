import React from "react";
import { Switch, Route } from "react-router-dom";
import { Home, List, Menu, Order, ShopSearch, NotFound } from "../pages";
export default function Router() {
  return (
    <Switch>
      <Route exact path={"/"} render={Home} />
      <Route path={"/list"} render={List} />
      <Route path={"/menu"} render={Menu} />
      <Route path={"/shopsearch"} render={Order} />
      <Route path={"/order"} render={ShopSearch} />
      <Route render={NotFound} />
    </Switch>
  );
}
