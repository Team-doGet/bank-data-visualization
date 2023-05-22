import React, { useEffect } from 'react';
import REGION from '../data/REGION';

const DotMap = ({ term, url }) => {
  useEffect(() => {
    const navermaps = window.naver.maps;
    const mapOptions = {
      center: new navermaps.LatLng(36.2666805, 127.8084147),
      zoom: 8,
    };
    const map = new navermaps.Map('map', mapOptions);
    fetch(`${url}&stDate=${term.start}&endDate=${term.end}&term=${term.type}`)
      .then((response) => response.json())
      .then((data) => {
        new naver.maps.visualization.DotMap({
          map: map,
          data: data.labels.map((e, i) => {
            const r = data.datasets[i];
            const w = r < 10 ? 1 : r < 100 ? 1.1 : r < 1000 ? 1.2 : r < 10000 ? 1.25 : 1.4;
            const { x, y } = REGION[e.replaceAll(' ', '')] || { x: 0, y: 0 };
            return { weight: w, location: [x, y] };
          }),
          radius: 25,
        });
      });
  }, [term]);

  return <div id="map" style={{ width: '100%', height: '100vh' }} />;
};

export default DotMap;
