<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <page-container>
    <template #content>
      <div class="container">
        <a-tabs v-model:active-key="activeKey" animated class="tabs">
          <template #rightExtra>
            <CustomLine />
          </template>
          <a-tab-pane key="1" tab="订单流水">
            <a-form :model="formState.order">
              <a-row :gutter="[30, 0]">
                <a-col :span="8">
                  <a-form-item name="name" label="商品名称">
                    <a-input v-model:value="formState.order.name" />
                  </a-form-item>
                </a-col>
                <a-col :span="8">
                  <a-form-item name="publishTime" label="下单时间">
                    <a-range-picker v-model:value="formState.order.publishTime" />
                  </a-form-item>
                </a-col>
                <a-col :span="8">
                  <a-form-item name="payTime" label="付款时间">
                    <a-range-picker v-model:value="formState.order.payTime" />
                  </a-form-item>
                </a-col>
              </a-row>
              <a-row :gutter="[30, 0]">
                <a-col :span="8">
                  <a-form-item name="status" label="订单状态">
                    <a-select v-model:value="formState.order.status" />
                  </a-form-item>
                </a-col>
              </a-row>
              <a-row :gutter="[30, 0]">
                <a-col :span="8">
                  <a-form-item>
                    <a-button type="primary" html-type="submit">查询</a-button>
                  </a-form-item>
                </a-col>
              </a-row>
            </a-form>
          </a-tab-pane>
          <a-tab-pane key="2" tab="交易流水">
            
          </a-tab-pane>
          <a-tab-pane key="3" tab="资金流水">

          </a-tab-pane>
        </a-tabs>
      </div>
    </template>
    <transition>
      <VendorWaterfallPage1 v-if="parseInt(activeKey) === 1" />
    </transition>
  </page-container>
</template>
<script lang="ts" setup>
import VendorWaterfallPage1 from './components/VendorWaterfallPage1.vue';
import { RangeValue } from '~@/types/form';
import dayjs from 'dayjs';
import CustomLine from './components/CustomLine.vue';

const activeKey = ref('1');
interface FormState {
  order: {
    name: String,
    price: Number,
    publishTime: RangeValue,
    payTime: RangeValue,
    status: Number
  }
}
const formState = ref({
  order: {
    name: "",
    price: 0.0,
    publishTime: [dayjs(), dayjs()],
    payTime: [dayjs(), dayjs()],
    status: 0
  }
})
</script>
<style lang="less">
:deep(.tabs){
  background: black;
  .ant-tabs-tab{
    align-items: end;
    background: black;
  }
}
</style>