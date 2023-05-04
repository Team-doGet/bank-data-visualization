import React, { useEffect } from 'react';
import TEST from '../data/test';

const DotMap = ({ test }) => {
  useEffect(() => {
    console.log(test);
    const navermaps = window.naver.maps;

    const mapOptions = {
      center: new navermaps.LatLng(37.5666805, 126.9784147),
      zoom: 7,
    };
    const map = new navermaps.Map('map', mapOptions);
    fetch('/api/deposit/customers/region.json')
      .then((response) => response.json())
      .then((data) => {
        new naver.maps.visualization.DotMap({
          map: map,
          data: data.labels.map((e, i) => {
            console.log({ weight: data.datasets[0].data[i], location: [TEST[e].x, TEST[e].y] });
            return { weight: data.datasets[0].data[i], location: [TEST[e].x, TEST[e].y] };
          }),
          radius: 20,
        });
      });
  }, []);

  return <div id="map" style={{ width: '100%', height: '100vh' }} />;
};

export default DotMap;
