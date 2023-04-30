import React from "react";
import BarChart from "../component/Chart/BarChart";
import HorizontalBarChart from "../component/Chart/HorizontalBarChart";
import AreaChart from "../component/Chart/AreaChart";
import LineChart from "../component/Chart/LineChart";
import MultiaxisLineChart from "../component/Chart/MultiaxisLineChart";
import PieChart from "../component/Chart/PieChart";
import DoughnutChart from "../component/Chart/DoughnutChart";
import PolarAreaChart from "../component/Chart/PolarAreaChart";
import RadarChart from "../component/Chart/RadarChart";
import ScatterChart from "../component/Chart/ScatterChart";
import BubbleChart from "../component/Chart/BubbleChart";
import MultitypeChart from "../component/Chart/MultitypeChart";

const Example = () => {
  return (
    <div>
      <BarChart></BarChart>
      <HorizontalBarChart></HorizontalBarChart>
      <AreaChart></AreaChart>
      <LineChart></LineChart>
      <MultiaxisLineChart></MultiaxisLineChart>
      <PieChart></PieChart>
      <DoughnutChart></DoughnutChart>
      <PolarAreaChart></PolarAreaChart>
      <RadarChart></RadarChart>
      <ScatterChart></ScatterChart>
      <BubbleChart></BubbleChart>
      <MultitypeChart></MultitypeChart>
    </div>
  );
};

export default Example;
