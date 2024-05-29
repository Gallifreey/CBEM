<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-row :gutter="[16, 0]">
        <a-col :span="12">
          <IOChart :data="leftChartData" style="height: 200px;"/>
        </a-col>
        <a-col :span="12">
          <a-form :model="formState">
            <a-row :gutter="[16, 32]">
              <a-col :span="12">
                <a-form-item name="name" label="商品名称">
                  <a-input v-model:value="formState.name" />
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item name="date" label="操作时间">
                  <a-range-picker v-model:value="formState.date" />
                </a-form-item>
              </a-col>
            </a-row>
            <a-row :gutter="[16, 32]">
              <a-col :span="12">
                <a-form-item name="in" label="入库数量">
                  <a-input-number style="width: 100%;" v-model:value="formState.in" />
                </a-form-item>
              </a-col>
              <a-col :span="12">
                <a-form-item name="out" label="出库数量">
                  <a-input-number style="width: 100%;" v-model:value="formState.out" />
                </a-form-item>
              </a-col>
            </a-row>
            <a-row>
              <a-button type="primary">查询</a-button>
            </a-row>
          </a-form>
        </a-col>
      </a-row>
    </template>
    <a-table :columns="StorageManagerIOColumn" :data-source="data">
      <template #bodyCell="{column}">
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <a-button type="link" danger>删除</a-button>
          </a-space>
        </template>
      </template>
    </a-table>
  </PageContainer>
</template>
<script lang="ts" setup>
import dayjs from 'dayjs';
import { RangeValue } from '~@/types/form';
import { StorageManagerIOColumn, StorageManagerIOType } from '~@/utils/columns'
import IOChart from './components/IOChart.vue';

const data = ref<StorageManagerIOType[]>([
  {
    date: dayjs(Date.now()),
    name: "1",
    size: "1",
    unit: "1",
    in: 10,
    out: 10,
    remained: 10,
    key: 0
  }
])
const leftChartData = [
  {
    type: "预期库存",
    value: 100
  },
  {
    type: "入库",
    value: 50
  },
  {
    type: "出库",
    value: 50
  },
  {
    type: "剩余库存",
    value: 100
  }
]
interface FormState {
  name: string,
  date: RangeValue,
  in: number,
  out: number,
}
const formState = ref<FormState>({
  name: "",
  date: [dayjs(), dayjs()],
  in: 0,
  out: 0
})
</script>
<style lang="less" scoped>

</style>