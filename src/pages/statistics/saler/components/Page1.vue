<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <a-card title="实时概况" hoverable>
      <PaymentChart :chart_data="paymentData"/>
    </a-card>
    <a-divider />
    <a-col :gutter="[16,16]" v-for="(_, index) in [0, 0]" :key="index">
      <a-row :gutter="[16, 16]">
        <a-col :span="8" v-for="(_, index_) in [0, 0, 0]" :key="index_">
          <InfoCard :data="infoData[index * 3 + index_]"/>
        </a-col>
      </a-row>
      <a-divider v-if="index < 1"/>
    </a-col>
  </div>
</template>
<script lang="ts" setup>
import PaymentChart from './PaymentChart.vue';
import InfoCard from './InfoCard.vue';

const paymentData = [
  {
    date: '20:00',
    price: 10,
    type: 'today'
  },
  {
    date: '21:00',
    price: 20,
    type: 'today'
  },
  {
    date: '22:00',
    price: 0,
    type: 'today'
  },
  {
    date: '20:00',
    price: 10,
    type: 'yesterday'
  },
  {
    date: '21:00',
    price: 0,
    type: 'yesterday'
  },
  {
    date: '22:00',
    price: 0,
    type: 'yesterday'
  }
]
const infoData = [
  {
    title: "访问人数",
    value: 0,
    unit: "人",
    increase: -100
  },
  {
    title: "支付人数",
    value: 1,
    unit: "人",
    increase: 0
  },
  {
    title: "访问支付转化率",
    value: undefined,
    unit: "%",
    increase: 0
  },
  {
    title: "打开次数",
    value: 0,
    unit: "次",
    increase: -100
  },
  {
    title: "支付笔数",
    value: 1,
    unit: "笔",
    increase: -50
  },
  {
    title: "退款金额",
    value: 0.01,
    unit: "元",
    increase: -97.22
  }
]
</script>
<style lang="less" scoped>

</style>