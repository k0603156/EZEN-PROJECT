import * as React from "react";

export default function useFetch(initialData, fetchAction) {
  const [response, setResponse] = React.useState(initialData);

  const fetchItem = async () => {
    try {
      const { status, data } = await fetchAction();
      if (status === 200) {
        setResponse(data);
      }
    } catch (error) {
      console.log(error.message);
    }
  };

  React.useEffect(() => {
    fetchItem();
  }, []);
  return [response, setResponse];
}
