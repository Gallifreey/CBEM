<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-row :gutter="[30, 0]">
        <a-col :span="8">
          <a-form-item name="name" label="仓库名称">
            <a-input v-model:value="formState.name" />
          </a-form-item>
        </a-col>
        <a-col :span="8">
          <a-form-item name="address" label="仓库地址">
            <a-input v-model:value="formState.address" />
          </a-form-item>
        </a-col>
        <a-col :span="8">
          <a-form-item name="authTime" label="授权时间">
            <a-range-picker v-model:value="formState.authTime" />
          </a-form-item>
        </a-col>
      </a-row>
      <a-row :gutter="[30, 0]">
        <a-col :span="8">
          <a-space>
            <a-button type="primary">查询</a-button>
            <a-button>添加仓库</a-button>
          </a-space>
        </a-col>
      </a-row>
    </template>
      <a-table :columns="StorageManagementColumns" :data-source="data">
        <template #bodyCell="{column}">
          <template v-if="column.dataIndex === 'action'">
            <a-space>
              <a-button type="link">修改</a-button>
              <a-button type="link" danger>取消授权</a-button>
            </a-space>
          </template>
        </template>
      </a-table>
  </PageContainer>
</template>
<script lang="ts" setup>
import dayjs from 'dayjs';
import { RangeValue } from '~@/types/form';
import { StorageManagementColumns, StorageManagerStorageManagementType } from '~@/utils/columns'

interface FormState {
  name: string,
  address: string,
  authTime: RangeValue
}
const formState = ref<FormState>({
  name: "",
  address: "",
  authTime: [dayjs(), dayjs()]
})
const data = ref<StorageManagerStorageManagementType[]>([
  {
    name: "1",
    address: "11",
    authTime: dayjs(Date.now()),
    key: 0
  }
])
</script>
<style lang="less" scoped>

</style>