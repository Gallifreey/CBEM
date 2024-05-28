<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <a-card :title="props.data.title" style="height: 200px;" hoverable>
    <template v-if="props.data.value !== undefined">
      <div style="display: flex;flex-direction: column;justify-content: space-between;height: 100%;">
        <div class="time">实时 {{ dayjs().format("YYYY-MM-DD hh:MM:ss")}}</div>
        <div class="value-panel">
          <div class="left-tag">
            <div class="value">
              {{ props.data.value }}
            </div>
            <div class="unit">
              {{ props.data.unit }}
            </div>
          </div>
          <div class="right-tag">
            <div class="increase">
              同期增幅 
            </div>
            <div class="increase-value">
              {{ props.data.increase }} %
            </div>
          </div>
        </div>
      </div>
    </template>
    <template v-else>
      <a-empty :image="simpleImage"/>
    </template>
  </a-card>
</template>
<script lang="ts" setup>
import dayjs from 'dayjs';
import { Empty } from 'ant-design-vue';
const simpleImage = Empty.PRESENTED_IMAGE_SIMPLE;

const props = defineProps({
  data: {
    type: Object,
    default: () => {
      return {
        title: ""
      }
    }
  }
})
</script>
<style lang="less" scoped>
.time::before{
  content: "·";
  color: red;
}
.value-panel{
  display: flex;
  justify-content: space-between;
}
.left-tag{
  display: flex;
  align-items: end;
  .value{
    font-weight: bold;
    font-size: 24px;
  }
  .unit{
    font-size: 14px;
    margin-left: 10px;
  }
}
.right-tag{
  display: flex;
  align-items: end;
  .value{
    font-weight: bold;
    font-size: 24px;
  }
  .unit{
    font-size: 14px;
    margin-left: 10px;
  }
}
</style>