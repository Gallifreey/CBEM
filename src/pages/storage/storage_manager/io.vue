<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <template #content>
      
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
import { StorageManagerIOColumn, StorageManagerIOType } from '~@/utils/columns'

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
</script>
<style lang="less" scoped>

</style>