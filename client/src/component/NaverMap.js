import React, { useEffect } from 'react';

const NaverMap = ({ branch }) => {
  useEffect(() => {
    const mapDiv = document.getElementById('map');
    const map = new window.naver.maps.Map(mapDiv, {
      center: new naver.maps.LatLng(37.5666805, 126.9784147),
      zoom: 10,
      mapTypeId: naver.maps.MapTypeId.NORMAL,
    });
    branch.forEach((e, i) => {
      new naver.maps.Marker({
        position: new naver.maps.LatLng(e.longitude, e.latitude),
        map: map,
      });
      new naver.maps.Marker({
        position: new naver.maps.LatLng(e.longitude, e.latitude),
        map: map,
        icon: {
          content: `<div class="badge rounded-pill bg-primary" id="branch${i}">${e.name}<div>`,
          size: new naver.maps.Size(22, 65),
          anchor: new naver.maps.Point(-15, 20),
        },
      });
    });
  });
  return <div id="map" style={{ width: '100%', height: '70vh' }} />;
};

export default NaverMap;
