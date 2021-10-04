/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009-2012, The University of Melbourne, Australia
 */
package org.cloudbus.cloudsim.network;

import org.cloudbus.cloudsim.hosts.Host;
import org.cloudbus.cloudsim.hosts.network.NetworkHost;

/**
 * Represents a packet which travels from one {@link Host} to another.
 * Each packet contains: IDs of the sender VM into the source Host and receiver VM into the destination Host which are
 * communicating; the time at which it is sent and received; type and virtual IDs of tasks.
 *
 * <p>Please refer to following publication for more details:
 * <ul>
 *   <li>
 *   <a href="https://doi.org/10.1109/UCC.2011.24">
 *   Saurabh Kumar Garg and Rajkumar Buyya, NetworkCloudSim: Modelling Parallel
 *   Applications in Cloud Simulations, Proceedings of the 4th IEEE/ACM
 *    International Conference on Utility and Cloud Computing (UCC 2011, IEEE CS
 *    Press, USA), Melbourne, Australia, December 5-7, 2011.
 *    </a>
 *    </li>
 * </ul>
 * </p>
 *
 * @author Saurabh Kumar Garg
 * @author Manoel Campos da Silva Filho
 *
 * @since CloudSim Toolkit 1.0
 */
public class HostPacket implements NetworkPacket<NetworkHost> {

    /**
     * Information about the virtual sender and receiver entities of the packet
     * (the sender and receiver Cloudlet and their respective VMs).
     */
    private final VmPacket vmPacket;

    /** @see #getSource() */
    private NetworkHost senderHost;

    /** @see #getDestination() */
    private NetworkHost receiverHost;

    /** @see #getSendTime() */
    private double sendTime;

    /** @see #getReceiveTime() */
    private double receiveTime;

    /**
     * Creates a packet to be sent through the network between two hosts.
     *
     * @param senderHost host sending the packet
     * @param vmPacket vm packet containing information of sender and receiver Cloudlets and their VMs.
     */
    public HostPacket(final NetworkHost senderHost, final VmPacket vmPacket) {
        this.vmPacket = vmPacket;
        this.sendTime = vmPacket.getSendTime();
        this.senderHost = senderHost;
    }

    /**
     * {@inheritDoc}
     * It is the size of the enclosing {@link VmPacket}.
     * @return {@inheritDoc}
     */
    @Override
    public long getSize() {
        return vmPacket.getSize();
    }

    /**
     * Gets the {@link Host} that this packet is coming from (the sender).
     * @return
     */
    @Override
    public NetworkHost getSource() {
        return senderHost;
    }

    /**
     * Sets the {@link Host} that this packet is coming from (the sender).
     * @param senderHost the source Host id to set
     */
    @Override
    public void setSource(final NetworkHost senderHost) {
        this.senderHost = senderHost;
    }

    /**
     * Gets the {@link Host} that the packet is going to.
     * @return
     */
    @Override
    public NetworkHost getDestination() {
        return receiverHost;
    }

    /**
     * Sets the {@link Host} that the packet is going to.
     * @param receiverHost the receiver Host id to set
     */
    @Override
    public void setDestination(final NetworkHost receiverHost) {
        this.receiverHost = receiverHost;
    }

    @Override
    public double getSendTime() {
        return sendTime;
    }

    @Override
    public void setSendTime(final double sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public double getReceiveTime() {
        return receiveTime;
    }

    @Override
    public void setReceiveTime(final double receiveTime) {
        this.receiveTime = receiveTime;
    }

    public VmPacket getVmPacket() {
        return vmPacket;
    }
}
