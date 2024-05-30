<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-row :gutter="[16, 16]">
        <a-col :span="10">
          <div class="count">
            <div>总收入<span>{{ data.in.toLocaleString() }}</span>元</div>
            <div>总支出<span>{{ data.out.toLocaleString() }}</span>元 </div>
          </div>
        </a-col>
        <a-col :span="14">
          <AreaChart :data="data.thisMonth" :x-label="'month'" :y-label="'value'"/>
        </a-col>
      </a-row>
    </template>
    <a-row :gutter="[16, 16]">
      <a-col :span="24">
        <a-card title="月结余数据">
          <BarChart :data="data.ioChart" :x-label="'date'" :y-label="'value'" />
        </a-card>
      </a-col>
    </a-row>
    <a-divider />
    <a-row :gutter="[16, 16]">
      <a-col :span="12">
        <a-card title="支付状态分布">
          <PieChart :data="data.typeChart" :x-label="'type'" :y-label="'value'" />
        </a-card>
      </a-col>
      <a-col :span="12">
        <a-card title="交易类型分布">
          <PieChart :data="data.stateChart" :x-label="'type'" :y-label="'value'" />
        </a-card>
      </a-col>
    </a-row>
  </PageContainer>
</template>
<script lang="ts" setup>
import BarChart from '~@/components/chart/BarChart.vue';
import PieChart from '~@/components/chart/PieChart.vue';
import AreaChart from '~@/components/chart/AreaChart.vue';

const data = {
  in: 100000.11,
  out: 1000,
  thisMonth: [
    { month: '1', value: 1078 },
    { month: '2', value: 1216 },
    { month: '3', value: 758 },
    { month: '4', value: 623 },
    { month: '5', value: 319 },
    { month: '6', value: 422 },
    { month: '7', value: -4 },
    { month: '8', value: -217 },
    { month: '9', value: -358 },
    { month: '10', value: 1513 },
    { month: '11', value: 1388 },
    { month: '12', value: 597 }
  ],
  ioChart: [
    {
      date: "2022-01-01",
      value: 100,
      type: "in"
    },
    {
      date: "2022-01-01",
      value: 100,
      type: "out"
    },
    {
      date: "2022-01-02",
      value: 100,
      type: "out"
    },
    {
      date: "2022-01-03",
      value: 100,
      type: "in"
    },
    {
      date: "2022-01-03",
      value: 100,
      type: "out"
    },
    {
      date: "2022-01-04",
      value: 100,
      type: "in"
    },
    {
      date: "2022-01-05",
      value: 100,
      type: "in"
    },
  ],
  typeChart:[
    {
      type:'退款',
      value:50
    },
    {
      type:'成交',
      value:100
    },
    {
      type:'阻塞',
      value:100
    }
  ],
  stateChart:[
    {
      type:'退款',
      value:50
    },
    {
      type:'成交',
      value:100
    },
    {
      type:'阻塞',
      value:100
    }
  ] 
}

</script>
<style lang="less" scoped>
.count{
  height: 400px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-size: 16px;
  color: gray;
  span{
    font-size: 30px;
    color: green;
    font-weight: bold;
  }
}
</style>