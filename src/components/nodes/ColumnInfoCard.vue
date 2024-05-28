<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-card :title="data?.title" hoverable>
    <div class="data-column" v-for="(item, index) in data?.meta" :key="index">
      <div class="bar">
        <span>{{ item.title }}</span>
        <div class="number">
          <span class="value">{{ item.value.toLocaleString() }}</span>
          <span class="unit">{{ item.unit }}</span>
        </div>
        <span :class="item.increase>0?'increase':'decrease'">{{ item.increase>0?'+':'' }}{{ item.increase }}%</span>
      </div>
    </div>
  </a-card>
</template>
<script lang="ts" setup>
import { Node } from '@antv/x6';

interface NodeData {
  title: string,
  meta: {
    title: string,
    value: number,
    unit: string,
    increase: number
  }[]
}
const getNode: Function | undefined = inject<Function>("getNode");
const data =  ref<NodeData|undefined>(undefined)
onMounted(() => {
  const node = getNode?.() as Node;
  data.value = node?.getData()
});
</script>
<style lang="less" scoped>
.data-column{
  line-height: 50px;
  .bar{
    display: flex;
    justify-content: space-between;
  }
  .number{
    width: 100px;
    text-align: right;
    .value{
      font-weight: bold;
    }
    .unit{
      margin-left: 10px;
      color: gray;
    }
  }
  .increase{
    color: green;
  }
  .decrease{
    color: red;
  }
}
</style>