import { useState } from "react";
import axios from "axios";
import MapView from "./MapView";

function App() {
  const [orders, setOrders] = useState([]);
  const [route, setRoute] = useState([]);

  const addOrder = () => {
    const newOrder = {
      id: orders.length + 1,
      lat: 16.5062 + Math.random() * 0.01,
      lon: 80.6480 + Math.random() * 0.01,
      priority: Math.random() > 0.5 ? "PRIME" : "NORMAL"
    };
    setOrders([...orders, newOrder]);
  };

  const optimize = async () => {
    const res = await axios.post("http://localhost:8080/route", orders);
    setRoute(res.data.stops);
  };

  return (
    <div>
      <h2>Smart Delivery</h2>
      <button onClick={addOrder}>Add Order</button>
      <button onClick={optimize}>Optimize</button>
      <MapView orders={orders} route={route} />
    </div>
  );
}

export default App;
