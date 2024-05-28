<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-card :title="data?.title" hoverable>
    <div class="content">
      <div class="data-area" v-for="(item, index) in data?.meta" :key="index">
        <div class="inner">
          <span class="title">{{ item.title }}</span>
          <div class="number">
            <span class="value">{{ item.value.toLocaleString() }}</span>
            <span class="unit">{{item.unit}}</span>
          </div>
          <span :class="item.increase>0?'increase':'decrease'">{{ item.increase>0?'+':'' }}{{ item.increase }}%</span>
        </div>
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
.content{
  display: flex;
  justify-content: space-evenly;
  flex-direction: row;
  .data-area{
    display: flex;
    flex-direction: column;
    text-align: center;
    .title{
      font-size: 16px;
      font-weight: bold;
    }
    .value{
      font-size: 20px;
      font-weight: bold;
    }
    .unit{
      font-size: 16px;
      color: gray;
    }
    .increase{
      color: green;
    }
    .decrease{
      color: red;
    }
  }
}
</style>