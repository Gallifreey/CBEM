<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <PageContainer>
    <a-row :gutter="[16, 16]">
      <a-col :span="6">
        <a-card title="商品看板">
          <template #title>
            <div class="update-time">
              更新于 {{ commodtyBoardData.update }}
            </div>
            <div class="compare-time">
              对比周期 {{commodtyBoardData.duration.join(' - ')}}
            </div>
          </template>
          <div class="data-column">
            <span class="title">诊断结果</span>
            <span class="status">正常</span>
            <span class="leverage">交易金额较平日平均水平 {{ commodtyBoardData.results.value }}%</span>
          </div>
          <a-divider />
          <div class="data-column">
            <span class="title">访问支付人数转化率</span>
            <span class="value">{{ commodtyBoardData.conversion.value }}%</span>
            <span :class="commodtyBoardData.conversion.increase>0?'increase':'decrease'">较平日 {{ commodtyBoardData.conversion.increase>0?'+':'-' }}{{ commodtyBoardData.conversion.increase }}%</span>
          </div>
          <a-divider />
          <div class="data-column">
            <span class="title">涨幅Top5指标</span>
            <div class="top5" v-for="(item, index) in commodtyBoardData.increaseTop5" :key="index">
              <div>
                <span style="margin-right: 5px;">{{index+1}}</span>
                <span>{{ item.title }}</span>
              </div>
              <span :class="item.value>0?'increase':'decrease'">{{ item.value>0?'+':'-' }}{{ item.value }}%</span>
            </div>
          </div>
          <a-divider />
          <div class="data-column">
            <span class="title">跌幅Top5指标</span>
            <div class="top5" v-for="(item, index) in commodtyBoardData.decreaseTop5" :key="index">
              <div>
                <span style="margin-right: 5px;">{{index+1}}</span>
                <span>{{ item.title }}</span>
              </div>
              <span :class="item.value>0?'increase':'decrease'">{{ item.value>0?'+':'' }}{{ item.value }}%</span>
            </div>
          </div>
        </a-card>
      </a-col>
      <a-col :span="18">
        <div class="container" ref="refDOM" style="height: 100%;width: 100%;"></div>
        <TeleportContainer />
      </a-col>
    </a-row>
  </PageContainer>
</template>
<script lang="ts" setup>
import { CommodityBoardType } from '~@/types/analyze'
import {Graph, Cell} from '@antv/x6';
import { userCreateVueNode } from '~@/utils/tools';
import { TeleportContainer } from '~@/utils/register';

const commodtyBoardData = ref<CommodityBoardType>({
  update: '21/03/29',
  duration: ['21/02/27', '21/03/08'],
  results: {
    status: 0,
    value: 83.21
  },
  conversion: {
    value: 28.5,
    increase: 52.29
  },
  increaseTop5: [
    {
      title: '下单金额',
      value: 171.70
    },
    {
      title: '未支付金额',
      value: 166.07
    },
    {
      title: '商品销量',
      value: 147.45
    },
    {
      title: '支付金额',
      value: 133.21
    },
    {
      title: '支付人数',
      value: 92.97
    }
  ],
  decreaseTop5: [
    {
      title: "商品曝光量",
      value: -18.11
    },
    {
      title: "被访问商品数",
      value: -3.10
    }
  ]
})
const graphData = {
  node: [
    {
      id: "node0",
      x: 0,
      y: 0,
      shape: 'planeInfoCard',
      meta: {
        title: "支付",
        meta: [
          {
            title: "商品访问人数(人)",
            value: 7407,
            unit: "",
            increase: 26.71
          },
          {
            title: "商品曝光量(次)",
            value: 12.25,
            unit: "万",
            increase: -18.11
          },
          {
            title: "被访问商品数(种)",
            value: 66,
            unit: "",
            increase: -3.10
          }
        ]
      }
    },
    {
      id: "node1",
      x: 0,
      y: 300,
      shape: 'columnInfoCard',
      meta: {
        title: "下单",
        meta: [
          {
            title: "下单人数",
            value: 784,
            unit: "人",
            increase: 81.37
          },
          {
            title: "下单笔数",
            value: 753,
            unit: "笔",
            increase: 171.70
          },
          {
            title: "下单金额",
            value: 123489.0,
            unit: "元",
            increase: 171.70
          }
        ]
      }
    },
    {
      id: "node2",
      x: 400,
      y: 300,
      shape: 'columnInfoCard',
      meta: {
        title: "加购",
        meta: [
          {
            title: "加购人数",
            value: 253,
            unit: "人",
            increase: 45.20
          },
          {
            title: "加购件数",
            value: 667,
            unit: "件",
            increase: 58.27
          }
        ]
      }
    },
    {
      id: "node3",
      x: 0,
      y: 700,
      shape: 'columnInfoCard',
      meta: {
        title: "支付",
        meta: [
          {
            title: "支付人数",
            value: 617,
            unit: "人",
            increase: 91.97
          },
          {
            title: "商品销量",
            value: 1243,
            unit: "件",
            increase: 147.45
          },
          {
            title: "支付笔数",
            value: 698,
            unit: "笔",
            increase: 97.19
          },
          {
            title: "支付金额",
            value: 114514,
            unit: "元",
            increase: 27.58
          }
        ]
      }
    },
    {
      id: "node4",
      x: 400,
      y: 700,
      shape: 'columnInfoCard',
      meta: {
        title: "未支付",
        meta: [
          {
            title: "未支付人数",
            value: 617,
            unit: "人",
            increase: 91.97
          },
          {
            title: "未支付笔数",
            value: 698,
            unit: "笔",
            increase: 97.19
          },
          {
            title: "未支付金额",
            value: 114514,
            unit: "元",
            increase: 27.58
          }
        ]
      }
    },
    {
      id: "node5",
      x: 0,
      y: 1150,
      shape: 'planeInfoCard',
      meta: {
        title: "退款",
        meta: [
          {
            title: "退款人数(人)",
            value: 7407,
            unit: "",
            increase: 26.71
          },
          {
            title: "退款金额(元)",
            value: 910.99,
            unit: "万",
            increase: 87.01
          },
          {
            title: "退款笔数(笔)",
            value: 66,
            unit: "",
            increase: -3.10
          }
        ]
      }
    }
  ],
  edge: [
    {
      source: 'node0',
      target: 'node1',
      size: 10
    }
  ]
}
const refDOM = ref();
let graph: Graph;
let createNode: any;
const graphInit = () => {
  graph = new Graph({
    autoResize: true,
    container: refDOM.value,
    mousewheel: {
      enabled: true,
      zoomAtMousePosition: true,
      modifiers: 'ctrl',
      minScale: 0.5,
      maxScale: 3,
    },
    interacting: {
      nodeMovable: false
    },
    panning: {
      enabled: true,
      eventTypes: ['mouseWheel']
    },
    background: {
      color: 'transparent',
    }
  });
  createNode = userCreateVueNode(graph)
}

const render = () => {
  const cells: Cell[] = []
  graphData.node.forEach((node: any) => {
    cells.push(createNode(node.id, node.x, node.y, node.shape, node.meta))
  })
  graphData.edge.forEach((edge: any) => {
    cells.push(graph.createEdge({
      target: edge.target,
      source: edge.source,
      attrs: {
          line: {
            stroke: '#C2C8D5',
            strokeDasharray: '10 10',
          },
        },
    }))
  })
  graph.resetCells(cells)
  graph.centerContent()
  graph.zoomToFit({ padding: 10, maxScale: 1 })
}
onMounted(() => {
  graphInit();
  render();
})
</script>
<style lang="less" scoped>
.data-column{
  display: flex;
  flex-direction: column;
  .title{
    font-weight: bold;
    margin-bottom: 10px;
  }
  .status{
    font-size: 24px;
    color: green;
    font-weight: bold;
  }
  .leverage{
    color: gray;
  }
  .value{
    font-size: 24px;
    font-weight: bold;
  }
  .increase{
    color: green;
  }
  .decrease{
    color: red;
  }
  .top5{
    display: flex;
    justify-content: space-between;
    line-height: 40px;
  }
}
</style>