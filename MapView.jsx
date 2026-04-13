import { MapContainer, TileLayer, Marker, Polyline } from "react-leaflet";
import "leaflet/dist/leaflet.css";

function MapView({ orders, route }) {
  const positions = route.map(o => [o.lat, o.lon]);

  return (
    <MapContainer center={[16.5062, 80.6480]} zoom={13} style={{ height: "500px" }}>
      <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />

      {orders.map(o => (
        <Marker key={o.id} position={[o.lat, o.lon]} />
      ))}

      {positions.length > 1 && <Polyline positions={positions} />}
    </MapContainer>
  );
}

export default MapView;
