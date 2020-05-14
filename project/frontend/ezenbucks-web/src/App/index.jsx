import React from "react";
import { ThemeProvider } from "styled-components";

import GlobalStyles from "../Styles/global";
import Theme from "../Styles/theme";

import Router from "./components/Router";
import Layout from "./components/Layout";

function App() {
  return (
    <ThemeProvider theme={Theme}>
      <GlobalStyles />
      <Layout>
        <Router />
      </Layout>
    </ThemeProvider>
  );
}

export default App;
