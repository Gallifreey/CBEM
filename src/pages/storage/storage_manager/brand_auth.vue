<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      <a-form :model="formState">
        <a-row :gutter="[16, 16]"> 
          <a-col :span="8">
            <a-form-item name="name" label="品牌名称">
              <a-input v-model:value="formState.name"/>
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item name="authTime" label="授权时间">
              <a-range-picker v-model:value="formState.authTime"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row>
          <a-space>
            <a-button @click="open = true">授权品牌</a-button>
            <a-button type="primary">查询</a-button>
          </a-space>
        </a-row>
      </a-form>
    </template>
    <a-table :columns="StorageManagerBrandColumn" :data-source="data">
      <template #bodyCell="{column}">
        <template v-if="column.dataIndex === 'action'">
          <a-space>
            <a-button size="small" type="link" danger>取消授权</a-button>
          </a-space>
        </template>
      </template>
    </a-table>
    <BrandAuthModal v-model:open="open"/>
  </PageContainer>
</template>
<script lang="ts" setup>
import dayjs from 'dayjs';
import { RangeValue } from '~@/types/form';
import { StorageManagerBrandType, StorageManagerBrandColumn } from '~@/utils/columns'
import BrandAuthModal from './components/BrandAuthModal.vue';

const data = ref<StorageManagerBrandType[]>([
  {
    key: 0,
    name: "你好",
    authTime: dayjs()
  }
])
interface FormState {
  name: string,
  authTime: RangeValue
}
const open = ref(false);
const formState = ref<FormState>({
  name: "",
  authTime: [dayjs(), dayjs()]
})
</script>
<style lang="less" scoped>

</style>